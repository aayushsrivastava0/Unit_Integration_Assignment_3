package validatorTest

import com.knoldus.validator.EmailValidator
import org.scalatest.funsuite.AnyFunSuite

class EmailValidatorTest extends AnyFunSuite {

  val emailValidator_object = new EmailValidator
  test("Checking with a valid Email Id") {

    val expectedResult = true
    val result = emailValidator_object.emailIdIsValid("aayush@gmail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id without '@'") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("aayushgmail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id with special characters in domain name") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("aayush@g???mail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id with special characters in recipient's Name") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("aayush??aayush@gmail.com")
    assert(expectedResult == result)
  }

  test("Checking if it returns false on passing an invalid Email Id with invalid Top Level Domain") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("aayush@gmail.cam")
    assert(expectedResult == result)
  }
}
