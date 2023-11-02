# ПРАКТИЧЕСКАЯ РАБОТА №9
Реализация программы: <br>
![ОКНО](https://github.com/Je1rei/Java-Tasks/blob/main/Task%208/Decorator/IMG/star.png) 
![ОКНО](https://github.com/Je1rei/Java-Tasks/blob/main/Task%208/Decorator/IMG/Presents.png) 
![ОКНО](https://github.com/Je1rei/Java-Tasks/blob/main/Task%208/Decorator/IMG/Girlands.png) 
![ОКНО](https://github.com/Je1rei/Java-Tasks/blob/main/Task%208/Decorator/IMG/All.png)
---
В программе используется паттерн **Стратегия** (Strategy). 
Этот паттерн позволяет определить семейство алгоритмов, инкапсулировать каждый из них и делать их взаимозаменяемыми.В данном случае, разные методы сортировки представляют собой разные стратегии, которые можно динамически выбирать и применять к массиву чисел без изменения кода контекста.
Программа, которую вы описали, использует следующие классы, интерфейсы и методы:

1. **Интерфейс `SortingStrategy`**:
    - `public void sort(int[] numbers)`: Метод, который каждая конкретная стратегия сортировки должна реализовать.
    - `boolean compare(int a, int b)`: Вспомогательный метод для сравнения двух чисел. Может быть переопределен в конкретных стратегиях.

2. **Класс `SelectionSort`**:
    - Реализует интерфейс `SortingStrategy` и реализует сортировку методом выбора (по умолчанию, сортировка от наименьшего к наибольшему).

3. **Класс `BubbleSort`**:
    - Реализует интерфейс `SortingStrategy` и реализует сортировку методом пузырька.

4. **Класс `CurrentContext`**:
    - Управляет выбором конкретной стратегии сортировки.
    - `public void setSortingMethod(SortingStrategy strategy)`: Устанавливает текущую стратегию сортировки.
    - `public SortingStrategy getStrategy()`: Получает текущую стратегию сортировки.
    - `public void sortNumbers(int[] numbers)`: Применяет текущую стратегию сортировки к массиву чисел.

5. **FXML файл `hello-view.fxml`**:
    - Определяет пользовательский интерфейс с элементами управления, такими как текстовые поля, кнопки и переключатели.

6. **Контроллер `HelloController`**:
    - Связывает элементы интерфейса с методами программы, определенными в Java-коде.
    - Методы:
        - `public void fillButtonClicked()`: Заполняет массив чисел на основе введенных данных.
        - `public void selectionSortButtonClicked()`: Сортирует массив методом выбора.
        - `public void bubbleSortButtonClicked()`: Сортирует массив методом пузырька.
        - `public void generateRandomArray()`: Генерирует случайный массив чисел.
        - `public void showArrayInTextField()`: Отображает массив в текстовом поле.
        - Другие методы, связанные с обработкой событий интерфейса.

