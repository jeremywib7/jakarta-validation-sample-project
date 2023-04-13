# Jakarta Validation Sample Project

Jakarta Validation is a popular validation framework used in Java applications. It provides a set of annotations that
can be used to validate Java objects and their properties. These annotations can be applied at the class, field, or
method level and can be used to enforce constraints on the values of these properties.

## Environment

- Java 17
- Springboot 3

## Usage/Examples

To use Jakarta Validation in your Java application, you need to add the Jakarta Validation library to your project's
classpath. You can do this by adding the following dependency to your pom.xml file:

```javascript
    <dependency>
        <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
        <version>3.0.0</version>
    </dependency>
```

Once you have added the dependency, you can start using Jakarta Validation in your code. To validate a Java object, you
can use the Validator interface, which provides several methods for validating objects and their properties.

#### Hello

```http
  POST /hello
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `firstName` | `string` | **Required**. First name |
| `lastName` | `string` | **Required**. Last name |
| `email` | `string` | **Required**. Email |
| `phoneNumber` | `string` | **Required**. Phone Number |
| `skills` | `Array` | **Required**. Skills |

```javascript
    @PostMapping("/hello")
    public ResponseEntity<Hello> sayHello(@Valid @RequestBody Hello hello){
        return new ResponseEntity<>(hello,HttpStatus.OK);
    }
```
## Screenshot

- Failed validation

<img width="748" alt="Screenshot 2023-04-13 at 21 00 40" src="https://user-images.githubusercontent.com/66008860/231783684-1fddca4c-0b36-4591-aa5f-3631b6b04037.png">

- Success validation

<img width="684" alt="Screenshot 2023-04-13 at 21 02 39" src="https://user-images.githubusercontent.com/66008860/231804364-034ee340-eb51-4575-861b-fcaaa9ff6bd4.png">



