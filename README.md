# JAVA8 In Action

JAVA8 공부 저장소

---

### 스트림(Stream) 이란?

일반적으로 데이터, 패킷, 비트 등의 일련의 연속성을 갖는 흐름을 의미

- 음성, 영상, 데이터 등의 작은 조각들이 하나의 줄기를 이루며 전송되는 데이터 열(列)

### 자바에서의 스트림이란 무엇인가?

<b>데이터 처리연산</b>을 지원하도록 <b>소스</b>에서 추출된 <b>연속된 요소</b>이다.

- 연속된 요소
    - Collection과 마찬가지로 Stream은 특정 요소 형식으로 이루어진 연속된 값 집합 인터페이스를 제공한다.
    - Collection의 경우에는 시간과 공간의 복잡성과 관련된 요소의 저장 및 접근 연산이 주를 이루고, Stream의 경우에는 filter, sorted, map과 같은 데이터를 처리하기 위한 계산식이
      주를 이룬다.
- 소스
    - Stream은 Collection, 배열, I/O 자원 등의 데이터 제공 <b>소스</b>로 부터 데이터를 소비한다.
- 데이터 처리 연산
    - Stream은 filter, map, reduce, find, match, sort 등의 함수형 프로그래밍 언어에서 일반적으로 지원하는 연산과 데이터베이스와 비슷한 연산을 지원한다.

책 '이것이 자바다' 에서 말하는 스트림이란 컬렉션(배열 포함)의 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자이다.

### 람다란 무엇인가?

<b>람다 표현식</b>은 메서드로 전달할 수 있는 익명 함수를 단순화한 것이라고 할 수 있다. 람다 표현식에는 이름은 없지만, 파라미터 리스트, 바디, 반환 형식, 발생할 수 있는 예외 리스트는 가질 수 있다.

- 익명
    - 보통의 메서드와 달리 이름이 없으므로 <b>익명</b>이라 표현한다. 구현해야 할 코드에 대한 걱정거리가 줄어든다.
- 함수
    - 람다는 메서드처럼 특정 클래스에 종속되지 않으므로 함수라고 부른다. 하지만 메서드처럼 파라미터 리스트, 바디, 반환 형식, 가능한 예외 리스트를 포함한다.
- 전달
    - 람다 표현식을 메서드 인수로 전달하거나 변수로 저장할 수 있다.
- 간결성
    - 익명 클래스처럼 많은 자질구래한 코드를 구현할 필요가 없다.

### 함수형 인터페이스란?

오직 하나의 추상메서드를 지정하는 인터페이스를 의미한다.
(많은 디폴트 메서드가 있더라도 추상 메서드가 오직 하나라면 함수형 인터페이스이다)
자바 8 라이브러리 설계자들은 java.util.function 패키지로 여러 가지 새로운 함수형 인터페이스를 제공한다.

### 실행 어라운드 패턴이란?

자원 처리(예를 들면 데이터베이스의 파일 처리)에 사용하는 순환 패턴은 자원을 열고, 처리한 다음에, 자원을 닫는 순서로 이루어진다. 설정과 정리과정은 대부분 비슷하다. 즉, 실제 자원을 처리하는 코드를 설정과 정리
두 과정이 둘러싸는 형태를 갖는다. 이러한 형식의 코드를 실행 어라운드 패턴이라고 부른다.

### Predicate

java.util.function.Predicate&lt;T&gt; 인터페이스는 test라는 추상메서드를 정의하며 test는 제네릭 형식의 T의 객체를 인수로 받아 불리언을 반환한다.

### Consumer

java.util.function.Consumer&lt;T&gt; 인터페이스는 제네릭 형식 T 객체를 받아서 void를 반환하는 accept 라는 추상 메서드를 정의한다. T 형식의 객체를 인수로 받아서 어떤 동작을
수행하고 싶을 때 Consumer 인터페이스를 사용할 수 있다.

### Function

java.util.function.Function&lt;T, R&gt; 인터페이스는 제네릭 형식 T를 인수로 받아서 제네릭 형식 R객체를 반환하는 추상 메서드 apply를 정의한다. 입력을 출력으로 매핑하는 람다를
정의할 때 Function 인터페이스를 활용할 수 있다.

### 기본형 특화

자바의 모든 형식은 참조형 아니면 기본형에 해당한다. 하지만 제네릭 파라미터에는 참조형만 사용할 수 있다. 자바에서는 기본형을 참조형으로 변환하는 기능을 제공한다. 이 기능을 <b>박싱</b>(boxing) 이라고
한다. 참조형을 기본형으로 변환하는 반대 동작을 <b>언박싱</b>(unboxing)이라고 한다. 또한 프로그래머가 편리하게 코드를 구현할 수 있도록 박싱과 언박싱이 자동으로 이루어지는 <b>오토박싱</b>(
autoboxing)이라는 기능도 제공한다.

하지만 이런 변환 과정은 비용이 소모된다. 박싱한 값은 기본형을 감싸는 래퍼며 힙에 저장된다. 따라서 박싱한 값은 메모리를 더 소비하며 기본형을 가져올 때도 메모리를 탐색하는 과정이 필요하다.

자바 8에서는 기본형을 입출력으로 사용하는 상황에서 오토박싱 동작을 피할 수 있도록 특별한 버전의 함수형 인터페이스를 제공한다. 예를 들어, IntPredicate 인터페이스는 1000이라는 값을 박싱하지 않는다.

일반적으로 특정 형식을 입력으로 받는 함수형 인터페이스의 이름 앞에는 DoublePredicate, IntConsumer, LongBinaryOperator, IntFunction 처럼 형식명이 붙는다.
Function 인터페이스는 ToIntFunction<T>, IntToDoubleFunction 등의 다양한 출력 형식 파라미터를 제공한다.

### 형식 검사

람다가 사용되는 컨텍스트(context)를 이용해서 람다의 형식(type)을 추론할 수 있다. 어떤 컨텍스트(예를 들면 람다가 전달될 메서드 파라미터나 람다가 할당되는 변수 등)에서 기대되는 람다 표현식의
형식을 <b>대상 형식</b>(target type)이라고 부른다. 람다 표현식을 사용할 때 실제 어떤 일이 일어나는지 예제를 통해 살펴본다.

```
List<Apple> heavierThan150g = filter(inventory, (Apple apple) -> apple.getWeight() > 150);
```

1. filter 메서드의 선언을 확인한다.
2. filter 메서드는 두 번째 파라미터로 Predicate<Apple> 형식(대상 형식)을 기대한다.
3. Predicate<Apple>은 test라는 한 개의 추상 메서드를 정의하는 함수형 인터페이스다.
4. test 메서드는 Apple을 받아 boolean을 반환하는 함수 디스크립터를 묘사한다.
5. filter 메서드로 전달된 인수는 이와 같은 요구사항을 만족해야 한다.

### 같은 람다, 다른 함수형 인터페이스

대상 형식이라는 특징 때문에 같은 람다 표현식이더라도 호환되는 추상 메서드를 가진 다른 함수형 인터페이스로 사용될 수 있다. Callable과 PrivilegedAction 인터페이스는 인수를 받지 않고 제네릭 형식
T를 반환하는 함수를 정의한다. 따라서 다음 두 할당문은 모두 유효한 코드다.

```
Callable<Integer> c = () -> 42;
PrivilegedAction<Integer> p = () -> 42;
```

### 특별한 void 호환 규칙

람다의 바디에 일반 표현식이 있으면 void를 반환하는 함수 디스크립터와 호환된다. 예를 들어 다음 두행의 예제에서 List의 add 메서드는 Consumer 콘텍스트(T -> void)가 기대하는 void 대신
boolean을 반환하지만 유효한 코드다.

```
// Predicate는 불리언 값을 갖는다.
Predicate<String> p = s -> list.add(s);
// Consumer는 void 반환값을 갖는다.
Consumer<String> b = s -> list.add(s);
```

### 형식 추론

코드를 좀 더 단순화 할 수 있는 방법이 있다. 자바 컴파일러는 람다 표현식이 사용된 콘텍스트(대상 형식)을 이용해서 람다 표현식과 관련된 함수형 인터페이스를 추론한다. 즉, 대상 형식을 이용해서 함수 디스크립터를
알 수 있으므로 컴파일러는 람다의 시그니처도 추론할 수 있다.

결과적으로 컴파일러는 람다 표현식의 파라미터 형식에 접근할 수 있으므로 람다 문법에서 이를 생략할 수 있다. 즉, 자바 컴파일러는 다음처럼 람다 파라미터 형식을 추론할 수 있다.

```
List<Apple> greenApples = filter(inventory, apple -> GREEN.equals(apple.getColor()));
```

파라미터 apple 에는 형식을 명시적으로 지정하지 않았다. 여러 파라미터를 포함하는 람다식에서는 코드 가독성 향상이 더 두드러진다.

상황에 따라 명시적으로 형식을 포함하는 것이 좋을 때도 있고, 형식을 배제하는 것이 가독성을 향상시킬 때도 있다. 어떤 방법이 좋은 정해진 규칙은 없다. 개발자 스스로 어떤 코드가 가독성을 향상시킬 수 있는지
결정해야 한다.

### 지역 변수 사용

람다 표현식에서는 익명 함수가 하는 것 처럼 자유 변수(파라미터로 넘겨진 변수가 아닌 외부에서 정의된 변수)를 활용할 수 있다. 이와 같은 동작을 람다 캡쳐링이라고 부른다.

```
int portNumber = 1337;
Runnable r = () -> System.out.println(portNumber);
```

하지만, 자유변수에도 약간의 제약이 있다. 람다는 인스턴스 변수와 정적 변수를 자유롭게 캡쳐(자신의 바디에서 참조할 수 있도록)할 수 있다.
하지만 그러려면, 지역 변수는 명시적으로 final로 선언되어 있어야 하거나 실질적으로는 final로 선언된 변수와 똑같이 사용되어야 한다.
즉, 람다 표현식은 한 번만 할당할 수 있는 지역 변수를 캡처할 수 있다.<br>

### 지역 변수의 제약
