
# Java Full-Stack Development Concepts  

## Importing Libraries  

```java
import java.lang.*;
```  
- **Purpose:** This statement imports all the classes from the `java.lang` package.  
- **Key Point:** You don’t need to explicitly write `import java.lang.*;` because this package is automatically imported in every Java program.  

---

## Basic Java Program  

```java
import java.lang.*;  
class Test1 {  
    public static void main(String[] args) {  
        System.out.println("Hello, World!");  
    }  
}
```  

### Code Explanation:  
1. **Import Statement:**  
   - `import java.lang.*;` is used to access classes like `String`, `Math`, etc., from the `java.lang` package.  
   - It’s optional as `java.lang` is imported by default.  

2. **Class Declaration:**  
   - `class Test1`: Declares a class named `Test1`.  
   - A class is a blueprint for creating objects and defining program behavior.  

3. **Main Method:**  
   - `public static void main(String[] args)` is the entry point of any Java application.  
     - `public`: Accessible from anywhere.  
     - `static`: Allows the method to be called without creating an object of the class.  
     - `void`: Specifies that the method does not return any value.  
     - `String[] args`: Accepts command-line arguments as an array of `String`.  

4. **Print Statement:**  
   - `System.out.println("Hello, World!");` prints `Hello, World!` to the console.  

---

## Static vs. Non-Static  

### Static:  
- Belongs to the **class**, not any specific object.  
- Accessed directly using the class name without creating an object.  
- Example:  

```java
class Example {  
    static int x = 10; // Static member  

    public static void display() { // Static method  
        System.out.println("Static method: x = " + x);  
    }  

    public static void main(String[] args) {  
        Example.display(); // Accessing static method  
    }  
}
```  

**Output:**  
```
Static method: x = 10  
```  

### Non-Static:  
- Belongs to an **object**, not the class.  
- Requires an object to access.  
- Example:  

```java
class Example {  
    int y = 20; // Non-static member  

    public void show() { // Non-static method  
        System.out.println("Non-static method: y = " + y);  
    }  

    public static void main(String[] args) {  
        Example obj = new Example(); // Creating an object  
        obj.show(); // Accessing non-static method  
    }  
}
```  

**Output:**  
```
Non-static method: y = 20  
```  

---

## Steps to Create an Object  

### Example:  
```java
Test7 t1 = new Test7();
```  

### Step-by-Step Explanation:  
1. **Class Reference:**  
   - `Test7 t1;` declares `t1` as a reference variable of type `Test7`.  
   - At this point, no memory is allocated for the object.  

2. **`new` Keyword:**  
   - `new` creates a new object of the `Test7` class in the heap memory.  
   - Memory is allocated for the object, and default values are assigned to non-static members.  

3. **Constructor Call:**  
   - `Test7()` is the constructor of the `Test7` class.  
   - It initializes the object and its non-static members with specific values.  

4. **Assigning the Reference:**  
   - The reference variable `t1` points to the newly created object in memory.  

### Default Initialization of Non-Static Members:  
- **Primitive Types:** Initialized with default values (e.g., `int = 0`, `boolean = false`).  
- **Reference Types:** Initialized to `null`.  

### Code Example:  

```java
class Test7 {  
    int num; // Non-static member  

    Test7() {  
        num = 100; // Initializing in constructor  
    }  

    public static void main(String[] args) {  
        Test7 t1 = new Test7(); // Creating an object  
        System.out.println("Object's num value: " + t1.num);  
    }  
}
```  

**Output:**  
```
Object's num value: 100  
```  

---
