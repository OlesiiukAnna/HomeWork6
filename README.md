Дз6
Написать свою собственную реализацию HashMap, HashSet.
Пример:
https://gist.github.com/akadatsky/3c1bba7f28ff488c6217ab1d64ed4a63
Остается доделать только методы containsKey/get/remove в MyHasMap

https://habr.com/ru/post/128017/
https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
https://docs.oracle.com/javase/8/docs/api/java/util/Map.html

Основные моменты по реализации:
1) Делаем аналог `Map<String, String> map = new HashMap<>();`
и `Set<String> set = new HashSet<>();`
2) При наличии HashMap, HashSet делает элементарно на его основе:
https://gist.github.com/akadatsky/3c1bba7f28ff488c6217ab1d64ed4a63#file-myhashset-java

Методы в образце написаны для примера и реализованы не самым лучшим образом.

Aльтернативное задание:
написать метод который принимает 2 строки - a, b. Метод должне вернуть количество символов которые у них различаются. Если строки разной длины то вернуть -1.
Примеры:
a="asdf", b="qwerty" => -1
a="abb", b="bba" => 0
a="abc", b="dca" => 1
a="aaa", b="fga" => 2
a="abc", b="dfg" => 3
