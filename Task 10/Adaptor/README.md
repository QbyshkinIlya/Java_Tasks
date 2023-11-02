# ПРАКТИЧЕСКАЯ РАБОТА №10
Реализация программы: <br>
![ОКНО](https://github.com/Je1rei/Java-Tasks/blob/main/Task%2010/Adaptor/src/IMG/img.png) 
![ОКНО](https://github.com/Je1rei/Java-Tasks/blob/main/Task%2010/Adaptor/src/IMG/img_1.png) 
![ОКНО](https://github.com/Je1rei/Java-Tasks/blob/main/Task%2010/Adaptor/src/IMG/img_2.png)
---
В программе используется паттерн **Адаптер** (Adaptor).
Паттерн "Адаптер" используется для адаптации структуры данных `OrdArray` для работы с общими методами в пользовательском интерфейсе. 
Работа включает следующие классы, интерфейсы и методы:

1. **Интерфейс `Adapter<E>`**:
   - `String toString(ArrayList<E> list)`: Метод для преобразования списка элементов в строку.
   - `void insert(E element)`: Метод для вставки элемента.
   - `void remove(E element)`: Метод для удаления элемента.
   - `E find(E element)`: Метод для поиска элемента.
   - `ArrayList<String> display()`: Метод для отображения текущего состояния структуры данных в виде списка строк.

2. **Класс `OrdArrayAdapter<E>`**:
   - Реализует интерфейс `Adapter<E>`.
   - Внутри класса есть экземпляр `OrdArray<E>`, представляющий "особую" структуру данных.

3. **Класс `OrdArray<E>`**:
   - Представляет "особую" структуру данных, адаптированную для использования в интерфейсе Adapter<E>.
   - Включает методы `insert, remove, find, display` и другие, необходимые для работы с данной структурой данных.

4. **Класс `HelloController`**:
   - Отвечает за управление интерфейсом и обработку событий.
   - Включает методы `onInsertClick, onDeleteClick, onSearchClick`, которые вызываются при соответствующих событиях в интерфейсе.
   - Также включает методы `insertItem, removeItem, findItem`, которые вызывают методы `insert, remove и find` из адаптера.
   - Обновляет `ListView` с помощью метода `updateListView`.
