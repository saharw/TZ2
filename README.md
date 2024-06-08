![Java CI](https://github.com/saharw/TZ2/actions/workflows/maven.yml/badge.svg)

## Обзор

Программа для `TZ2` предназначена для чтения списка чисел из указанного файла и выполнения различных арифметических операций, таких как нахождение минимума, максимума, суммы и произведения. Программа сопровождается набором модульных тестов для проверки её функциональности и производительности.

## Функции

- **Чтение из файла**: Чтение серии чисел из текстового файла, где числа разделены пробелами.
- **Вычисление минимума**: Нахождение и возврат минимального числа из списка.
- **Вычисление максимума**: Нахождение и возврат максимального числа из списка.
- **Вычисление суммы**: Вычисление и возврат суммы всех чисел в списке.
- **Вычисление произведения**: Вычисление и возврат произведения всех чисел в списке.

## Классы и методы

### Класс NumberProcessor

- **Конструктор**: `NumberProcessor(String path)`
  - Считывает содержимое файла, указанного в `path`, и инициализирует массив чисел типа `BigInteger`.

- **Методы**:
  - `_min()`: Возвращает минимальное значение из массива чисел.
  - `_max()`: Возвращает максимальное значение из массива чисел.
  - `_sum()`: Возвращает сумму всех чисел в массиве.
  - `_mult()`: Возвращает произведение всех чисел в массиве.
  
![execution_time_graph](https://github.com/saharw/TZ2/assets/82721573/2e199a63-781a-4688-a624-582b68556f7c)
Итоговая асимптотика:

Методы _min(), _max(), _sum(): **O(N)**
### Класс NumberProcessorTest

- **Подготовка данных**: 
  - `setUp()`: Создаёт файлы с тестовыми данными различного размера для проверки функциональности методов.
  
- **Тесты**:
  - `testMin()`: Проверяет правильность нахождения минимального значения.
  - `testMax()`: Проверяет правильность нахождения максимального значения.
  - `testSum()`: Проверяет правильность вычисления суммы.
  - `testMult()`: Проверяет правильность вычисления произведения.
  - `testLargeFileMin()`: Проверяет правильность нахождения минимального значения для большого файла.
  - `testLargeFileMax()`: Проверяет правильность нахождения максимального значения для большого файла.
  - `testLargeFileSum()`: Проверяет правильность вычисления суммы для большого файла.
  - `testAveragePerformance()`: Измеряет среднее время выполнения операций для файлов различного размера.

## Использование

Для использования программы необходимо создать экземпляр класса `NumberProcessor`, передав в его конструктор путь к файлу с числами, а затем вызвать нужные методы для получения результатов.

Пример использования:

```java
NumberProcessor processor = new NumberProcessor("example.txt");
BigInteger min = processor._min();
BigInteger max = processor._max();
BigInteger sum = processor._sum();
BigInteger mult = processor._mult();
