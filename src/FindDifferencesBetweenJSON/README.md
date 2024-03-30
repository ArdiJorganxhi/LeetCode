Implement a simple prototype service to find the difference between two JSON JavaScript Object
Notation) objects.
To keep the prototype simple, a JSON will contain only key-value pairs and no nested objects or arrays in it. Given two JSON strings, json1 and json2, find the list of keys for which the values are different. If a key is present in only one of the JSONs, it should not be considered in the result. The list of keys should be sorted in lexicographically ascending order.
Example:
Suppose json 1 =" 
("hello": "world", "hi": "hello", "you":"me")" and json2= " {"hello":"world", "hi": "helloo", "you":"me"}"
The only common key where the values differ is
"hi". Hence the answer is ["hi"].