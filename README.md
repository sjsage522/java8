# JAVA8 In Action

JAVA8 공부 저장소

---

## 람다 표현식

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
두 과정이 둘러싸는 형태를 갖는다. 이러한 형식의 코드를 실행 어라운드 패턴이라고 부른다. <br>
<i>reference : http://clearpal7.blogspot.com/2017/03/8_90.html </i>

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

하지만, 자유변수에도 약간의 제약이 있다. 람다는 인스턴스 변수와 정적 변수를 자유롭게 캡쳐(자신의 바디에서 참조할 수 있도록)할 수 있다. 하지만 그러려면, 지역 변수는 명시적으로 final로 선언되어 있어야
하거나 실질적으로는 final로 선언된 변수와 똑같이 사용되어야 한다. 즉, 람다 표현식은 한 번만 할당할 수 있는 지역 변수를 캡처할 수 있다.<br>

### 지역 변수의 제약

지역 변수에 왜 이런 제약이 필요한가? <br>
우선 내부적으로 인스턴스 변수와 지역 변수는 태생부터 다르다. 인스턴스 변수는 힙에 저장되는 반면 지역 변수는 스택에 위치한다. 람다에서 지역 변수에 바로 접근할 수 있다는 가정하에 람다가 스레드에서 실행된다면
변수를 할당한 스레드가 사라져서 변수 할당이 해제되었는데도 람다를 실행하는 스레드에서는 해당 변수에 접근하려 할 수 있다. <br>
따라서 자바 구현에서는 원래 변수에 접근을 허용하는 것이 아니라 자유 지역 변수의 복사본을 제공한다. 따라서 복사본의 값이 바뀌지 않아야 하므로 지역 변수에서는 한 번만 값을 할당해야 한다는 제약이 생긴
것이다. <br>

### 메서드 참조

메서드 참조를 이용하면 기존의 메서드 정의를 재활용해서 람다처럼 전달할 수 있다. 때로는 람다 표현식보다 메서드 참조를 이용하는 것이 더 가독성이 좋으며 자연스러울 수 있다.
<br>

기존 코드

```
inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight));
```

메서드 참조와 Comparator.comparing을 활용한 코드

```
inventory.sort(comparing(Apple::getWeight));
```

예제 ↓

```
//1. 정적 메서드를 호출하는 람다 표현식
ToIntFunction<String> stringToInt = (String s) -> Integer.parseInt(s); 
Function<String, Integer> stringToInteger = Integer::parseInt;

//2. 인스턴스 메서드 참조
BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element); 
BiPredicate<List<String>, String> contains = List::contains;

//3. 기존 객체의 인스턴스 메서드 참조
Predicate<String> startsWithNumber = (String string) -> this.startsWithNumber(string);
Predicate<String> startsWithNumber = this::startsWithNumber;
```

### 정리

- <b>람다 표현식</b>은 익명 함수의 일종이다. 이름은 없지만, 파라미터 리스트, 바디, 반환 형식을 가지며 예외를 던질 수 있다.
- 람다 표현식으로 간결한 코드를 구현할 수 있다.
- <b>함수형 인터페이스</b>는 하나의 추상 메서드만을 정의하는 인터페이스이다.
- 함수형 인터페이스를 기대하는 곳에서만 람다 표현식을 사용할 수 있다.
- 람다 표현식을 이용해서 함수형 인터페이스의 추상 메서드를 즉석으로 제공할 수 있으며 <b>람다 표현식 전체가 함수형 인터페이스의 인스턴스로 취급된다.</b>
- java.util.function 패키지는 Predicate&lt;T>, Function<T, R>, Supplier&lt;T>, Consumer&lt;T>, BinaryOperator&lt;T> 등을 포함해서
  자주 사용하는 다양한 함수형 인터페이스를 제공한다.
- 실행 어라운드 패턴(예를 들면 자원할당, 자원 정리 등 코드 중간에 실행해야 하는 메서드에 꼭 필요한 코드)을 람다와 활용하면 유연성과 재사용성을 추가로 얻을 수 있다.
- 메서드 참조를 이용하면 기존의 메서드 구현을 재사용하고 직접 전달할 수 있다.
- Comparator, Predicate, Function 같은 함수형 인터페이스는 람다 표현식을 조합할 수 있는 다양한 디폴트 메서드를 제공한다.

## 스트림 소개

거의 모든 자바 애플리케이션은 컬렉션을 만들고 처리하는 과정을 포함한다. 컬렉션으로 데이터를 그룹화하고 처리할 수 있다. 컬렉션은 대부분의 프로그래밍 작업에 사용된다.<br>
예를 들어, 메뉴를 구성하는 컬렉션이 있는데 컬렉션의 요리를 반복하면서 각 요리의 칼로리양을 더한다. 어떤 사람은 컬렉션에서 칼로리가 적은 요리만 골라 특별 건강 메뉴를 구성하고 싶을지도 모른다.
> 대부분의 자바 애플리케이션에서는 컬렉션을 많이 사용하지만 완벽한 컬렉션 관련 연산을 지원하려면 한참 멀었다.

- 대부분의 비즈니스 로직에는 요리를 카테고리(예를 들면 채식주의자용)로 그룹화한다든가 가장 비싼 요리를 찾는 등의 연산이 포함된다. 대부분의 데이터베이스에서는 선언형으로 이와 같은 연산을 표현할 수 있다. <br>
  예를 들어 SELECT name FROM dishes WHERE calorie < 400 이라는 문장은 칼로리가 낮은 요리명을 선택하라는 SQL 질의다. <br>
  SQL 질의에서 알 수 있듯이 요리의 속성을 이용하여 어떻게 필터링할 것인지는 구현할 필요가 없다. (예를 들어 자바처럼 반복자, 누적자 등을 이용할 필요가 없다) <br>
  SQL 질의 언어에서는 우리가 기대하는 것이 무엇인지 직접 표현할 수 있다. 즉, SQL 에서는 질의를 어떻게 구현해야 할지 명시할 필요가 없으며 구현은 자동으로 제공된다. <br>
  컬렉션으로도 이와 비슷한 기능을 만들 수 있지 않을까?
- 많은 요소를 포함하는 커다란 컬렉션은 어떻게 처리해야 할까? 성능을 높이려면 멀티코어 아키텍처를 활용해서 병렬로 컬렉션의 요소를 처리해야 한다. <br>
  하지만, 병렬 처리 코드를 구현하는 것은 단순 반복 처리 코드에 비해 복잡하고 어렵다. 게다가 복잡한 코드는 디버깅도 어렵다.

프로그래머가 귀중한 시간을 절약하고, 편리한 삶을 누릴 수 있도록 자바 언어 설계자들은 어떤 결정을 내렸을까? 이 질문의 답은 스트림이다.

### 스트림이란 무엇인가?

<b>스트림(stream)</b>은 자바8 API에 새로 추가된 기능이다. 스트림을 이용하면 선언형(즉, 데이터를 처리하는 임시 구현 코드 대신 질의로 표현할 수 있다)으로 컬렉션 데이터를 처리할 수 있다.<br>
일단 스트림이 데이터 컬렉션 반복을 멋지게 처리하는 기능이라고 생각하자. 또한, 스트림을 이용하면 멀티스레드 코드를 구현하지 않아도 데이터를 <b>투명하게</b> 병렬로 처리할 수 있다. <br>
스트림의 새로운 기능이 소프트웨어 공학적으로 다음의 다양한 이득을 줄 수 있다.

- 선언형으로 코드를 구현할 수 있다. 즉, 루프와 if 조건문 등의 제어 블록을 사용해서 어떻게 동작을 구현할지 지정할 필요 없이 '저칼로리의 요리만 선택하라' 같은 동작의 수행을 지정할 수 있다.<br>
  선언형 코드와 동작 파라미터화를 활용하면 변하는 요구사항에 쉽게 대응할 수 있다. 즉, 기존 코드를 복사하여 붙여 넣는 방식을 사용하지 않고, 람다 표현식을 이용해서 저칼로리 대신 고칼로리의 요리만 필터링하는
  코드도 쉽게 구현할 수 있다.
- filter, sorted, map, collect 같은 여러 빌딩 블록 연산을 연결해서 복잡한 데이터 처리 파이프라인을 만들 수 있다. <br>
  여러 연산을 파이프라인으로 연결해도 여전히 가독성과 명확성이 유지된다. filter 메서드의 결과는 sorted 메서드로, 다시 sorted 결과는 map 메서드로, map 메서드의 결과는 collect로
  연결된다.

filter (또는 sorted, map, collect) 같은 연산은 <b>고수준 빌딩 블록</b>으로 이루어져 있으므로 특정 스레딩 모델에 제한되지 않고 자유롭게 어떤 상황에서든 사용할 수 있다. 결과적으로
우리는 데이터 처리 과정을 병렬화하면서 스레드와 락을 걱정할 필요가 없다. 이 모든 것이 스트림 API 덕분이다.

---

#### 기타 라이브러리 : 구아바, 아파치, 람다제이

자바 프로그래머가 컬렉션을 제어하는 데 도움이 되는 다양한 라이브러리가 있다. <br>
구글의 구아바(Guava)는 멀티맵, 멀티셋 등 추가적인 컨테이너 클래스를 제공한다. 아파치 공통 컬렉션(Apache Commons Collections)라이브러리도 비슷한 기능을 제공한다.<br>
람다제이(lambdaj)는 함수형 프로그래밍에서 영감을 받은 선언형으로 컬렉션을 제어하는 다양한 유틸리티를 제공한다. <br>
<i> [Guava] : https://github.com/google/guava </i><br>
<i> [Apache] : https://github.com/apache/commons-collections </i><br>
<i> [Lambdaj] : https://github.com/mariofusco/lambdaj </i><br>

---

자바 8의 스트림 API의 특징을 다음처럼 요약할 수 있다.

- 선언형 : 더 간결하고 가독성이 좋아진다.
- 조립할 수 있음 : 유연성이 좋아진다.
- 병렬화 : 성능이 좋아진다.

### 스트림 시작하기

간단한 스트림 작업인 컬렉션 스트림부터 살펴본다. 자바 8 컬렉션에는 스트림을 반환하는 stream 메서드가 추가되었다. (java.util.stream.Stream) <br>
스트림이란? 맨처음에도 설명했지만 다시 환기를 해보자면, '데이터 처리 연산을 지원하는 소스에서 추출된 연속된 요소' 로 정의할 수 있다.

- 연속된 요소
    - 컬렉션과 마찬가지로 스트림은 특정 요소 형식으로 이루어진 연속된 값 집합의 인터페이스를 제공한다.
    - 컬렉션은 자료구조 이므로, 컬렉션에서는 시간과 공간의 복잡성과 관련된 요소 저장 및 접근 연산이 주를 이준다. 반면 스트림은 filter, sorted, map 처럼 표현 계산식이 주를 이룬다.
    - 즉, 컬렉션의 주제는 데이터고 스트림의 주제는 계산이다.
- 소스
    - 스트림은 컬렉션, 배열, I/O 자원 등의 데이터 제공 소스로부터 데이터를 소비한다.
    - 정렬된 컬렉션으로 스트림을 생성하면 정렬이 그대로 유지된다. 즉, 리스트로 스트림을 만들면 스트림의 요소는 리스트의 요소와 같은 순서를 유지한다.
- 데이터 처리 연산
    - 스트림은 함수형 프로그래밍 언어에서 일반적으로 지원하는 연산과 데이터베이스와 비슷한 연산을 지원한다.
    - 예를 들어 filter, map, reduce, find ,match, sort 등으로 데이터를 조작할 수 있다.
    - 스트림 연산은 순차적으로 또는 병렬로 실행할 수 있다.

또한, 스트림에는 다음과 같은 두 가지 중요한 특징이 있다.

- 파이프 라이닝(Pipelining) : 대부분의 스트림 연산은 스트림 연산끼리 연결해서 커다란 파이프 라인을 구성할 수 있도록 스트림 자원을 반환한다. 연산 파이프라인은 데이터 소스에 적용하는 데이터베이스 질의와
  비슷하다.
- 내부 반복 : 반복자를 이용해서 명시적으로 반복하는 컬렉션과 달리 스트림은 내부 반복을 지원한다.

### 스트림과 컬렉션

데이터를 <b>언제</b> 계산하느냐가 컬렉션과 스트림의 가장 큰 차이이다. 컬렉션은 현재 자료구조가 포함하는 모든 값을 메모리에 저장하는 자료구조이다. <br>
즉, 컬렉션의 모든 요소는 컬렉션에 추가하기 전에 계산되어야 한다. (컬렉션에 요소를 추가하거나 컬렉션의 요소를 제거할 수 있다. 이런 연산을 수행할 때마다 컬렉션의 모든 요소를 메모리에 저장해야 하며 컬렉션에
추가하려는 요소는 미리 계산되어야 한다) <br>

반면 스트림은 이론적으로 <b>요청할 때만 요소를 계산</b>하는 고정된 자료구조이다. (스트림에 요소를 추가하거나 스트림에서 요소를 제거할 수 없다)
결과적으로 스트림은 생산자와 소비자 관계를 형성한다. 또한 스트림은 게으르게 만들어지는 컬렉션과 같다. <br>
즉, 사용자가 데이터를 요청할 때만 값을 계산한다.

반면, 컬렉션은 적극적으로 생성된다. (생산자 중심 : 팔기도 전에 창고를 가득 채움) 소수 예제를 들어보면, 컬렉션은 끝이 없는 모든 소수를 포함하려 할 것이므로 무한 루프를 돌면서 새로운 소수를 계산하고
추가하기를 반복할 것이다. 결국 소비자는 영원히 결과를 볼 수 없게 된다.

> 스트림은 단 한번만 소비할 수 있다.
> ```
> List<String> title = Arrays.asList("Java8", "In", "Action");
> Stream<String> title.stream();
> s.forEach(System::out::println);
> s.forEach(System::out::println); //java.lang.IllegalStateException : 스트림이 이미 소비되었거나 닫힘
> ```

### 외부 반복과 내부 반복

컬렉션 인터페이스를 사용하려면 사용자가 직접 요소를 반복해야 한다. (예를 들면 for-each 등을 사용해서) 이를 <b>외부 반복</b>(external iteration)이라고 한다. 반면 스트림
라이브러리는 (반복을 알아서 처리하고 결과 스트림값을 어딘가에 저장해주는) <b>내부 반복</b>(internal iteration)을 사용한다. <br>

### 스트림 연산

연결할 수 있는 스트림 연산을 <b>중간 연산</b>이라고 하며, 스트림을 닫는 연산을 <b>최종 연산</b>이라고 한다.

#### 중간 연산

filter나 sorted 같은 중간 연산은 다른 스트림을 반환한다. 따라서 여러 중간 연산을 연결해서 질의를 만들 수 있다. 중간 연산의 중요한 특징은 단말 연산을 스트림 파이프라인에 실행하기 전까지는 아무 연산도
수행하지 않는다는 것, 즉 게으르다(lazy)는 것이다. <br>
중간 연산을 합친 다음에 합쳐진 중간 연산을 최종 연산으로 한 번에 처리하기 때문이다.

스트림 파이프라인에서 어떤 일이 일어나는지 쉽게 확인할 수 있도록 람다가 현재 처리 중인 요리를 출력해보자.

```
List<String> names = 
     menu.stream()
         .filter(dish -> {
            System.out.println("filtering:" + dish.getName());
            return dish.getCalories() > 300;
         }) //필터링한 요리명을 출력한다.
         .map(dish -> {
            System.out.println("mapping:" + dish.getName());
            return dish.getName();
         }) //추출한 요리명을 출력한다.
         .limit(3)
         .collect(toList());
System.out.println(names);
```

다음은 프로그램 실행 결과다.

```
filtering:pork
mapping:pork
filtering:beef
mapping:beef
filtering:chicken
mapping:chicken
[pork, beef, chicken]
```

스트림의 게으른 특성 덕분에 몇 가지 최적화 효과를 얻을 수 있었다. 첫째로, 칼로리가 300이 넘는 요리는 여러 개지만 오직 처음 3개만 선택되었다. <br>
이는 limit 연산 그리고 <b>쇼트서킷</b>이라 불리는 기법 덕분이다. 둘째로, filter와 map은 서로 다른 연산이지만 한 과정으로 병합되었다. (이 기법을 <b>루프퓨전</b> 이라고 한다)

#### 최종 연산

최종 연산은 스트림 파이프라인에서 결과를 도출한다. 보통 최종 연산에 의해 List, Integer, void 등 스트림 이외의 결과가 반환된다. 예를 들어 다음 파이프라인에서 forEach는 소스의 각 요리에
람다를 적용한 다음에 void를 반환하는 최종 연산이다. <br>
System.out.println를 forEach에 넘겨주면 menu에서 만든 스트림의 모든 요리를 출력한다.

```
menu.stream().forEach(System.out::println);
```

### 스트림 이용하기

스트림 이용 과정은 다음과 같이 세 가지로 요약할 수 있다.

- 질의를 수행할 (컬렉션 같은) 데이터 소스
- 스트림 파이프라인을 구성할 중간 연산 연결
- 스트림 파이프라인을 실행하고 결과를 만들 최종 연산

스트림 파이프라인의 개념은 빌더 패턴(Builder Pattern)과 비슷하다. 빌더 패턴에서는 호출을 연결해서 설정을 만든다(스트림에서 중간 연산을 연결하는 것과 같다). 그리고 준비된 설정에 build 메서드를
호출한다(스트림에서는 최종 연산에 해당함).

### 정리

- 스트림은 데이터 소스에서 추출된 연속 요소로, 데이터 처리 연산을 지원한다.
- 스트림은 내부 반복을 지원한다. 내부 반복은 filter, map, sorted 등의 연산으로 반복을 추상화한다.
- 스트림에는 중간 연산과 최종 연산이 있다.
- 중간 연산은 filter와 map처럼 스트림을 반환하면서 다른 연산과 연결되는 연산이다. 중간 연산을 이용해서 파이프라인을 구성할 수 있지만, 중간 연산으로는 어떠한 결과도 생성할 수 없다.
- forEach나 count처럼 스트림 파이프라인을 처리해서 스트림이 아닌 결과를 반환하는 연산을 최종 연산이라고 한다.
- 스트림의 요소는 요청할 때 게으르게(lazily) 계산된다.
