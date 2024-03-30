package FindDifferencesBetweenJSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static List<String> extractWords(String json) {
        Pattern pattern = Pattern.compile("\"([^\"]+)\":\\s*\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(json);
        List<String> words = new ArrayList<>();

        while (matcher.find()) {
            words.add(matcher.group(1));
            words.add(matcher.group(2));
        }
        return words;
    }

    private static Map<String, String> createKeyValuePairs(String json) {
        List<String> words = extractWords(json);
        Map<String, String> keyValuePairs = new HashMap<>();
        for(int i = 0; i < words.size(); i+=2) {
            if (i + 1 < words.size()) {
                keyValuePairs.put(words.get(i), words.get(i + 1));
            }
        }
        return keyValuePairs;
    }

    private static List<String> getJSONDiff(String json1, String json2) {
        Map<String, String> keyValuePairForJson1 = createKeyValuePairs(json1);
        Map<String, String> keyValuePairForJson2 = createKeyValuePairs(json2);

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, String> entry: keyValuePairForJson1.entrySet()) {
            String key = entry.getKey();
            String value1 = entry.getValue();
            String value2 = keyValuePairForJson2.get(key);

            if(value2 != null && !value1.equals(value2)) {
                result.add(key);
            }
        }
        return result;
    }
}
