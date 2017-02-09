package tri

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class implements a ScalaTest test suite for the methods in object `Insertion` that need to be implemented as part of
 * this assignment. A test suite is simply a collection of individual tests for some specific component of a program.
 *
 * A test suite is created by defining a class which extends the type `org.scalatest.FunSuite`. When running ScalaTest, it will
 * automatically find this class and execute all of its tests.
 *
 * Adding the `@RunWith` annotation enables the test suite to be executed inside eclipse using the built-in JUnit test runner.
 *
 * You have two options for running this test suite:
 *
 * - Right-click this file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class TriSuite extends FunSuite {

  import Insertion._

  /**
   * Test Insert
   */

  test("Insert - add min value") {
    assert(insert(0, List(1, 2, 3)) === List(0, 1, 2, 3))
  }

  test("Insert - add max value") {
    assert(insert(3, List(0, 1, 2)) === List(0, 1, 2, 3))
  }

  test("Insert - add a value") {
    assert(insert(2, List(0, 1, 3)) === List(0, 1, 2, 3))
  }

  test("Insert - add a value in a empty list") {
    assert(insert(3, List()) === List(3))
  }

  test("Insert - add a existing value") {
    assert(insert(1, List(0, 1, 2, 3)) === List(0, 1, 1, 2, 3))
  }

  /**
   * Test Tri
   */
  test("Tri - empty list") {
    assert(triIns(List()) === List())
  }

  test("Tri - test happy") {
    assert(triIns(List(45, 23, 0, 3, 1, 3, 6)) === List(0, 1, 3, 3, 6, 23, 45))
  }

  /**
   * Test Insert with order function
   */

  test("Insert - with order function - add min value") {
    assert(insert(0, List(1, 2, 3), (x, y) => x < y) === List(0, 1, 2, 3))
  }

  test("Insert - with order function - add max value") {
    assert(insert(5, List(1, 2, 3), (x, y) => x < y) === List(1, 2, 3, 5))
  }

  test("Insert - with order function - add a value") {
    assert(insert(2, List(0, 1, 3), (x, y) => x < y) === List(0, 1, 2, 3))
  }

  test("Insert - with order function - Test empty list") {
    assert(insert(3, List(), (x, y) => x > y) === List(3))
  }

  /**
   * Test Tri with order function
   */
  test("Tri - with order function - empty list") {
    assert(triDecroissant(List()) === List())
    assert(triCroissant(List()) === List())
  }

  test("Tri - with order function - test happy") {
    assert(triCroissant(List(45, 23, 0, 3, 1, 3, 6)) === List(0, 1, 3, 3, 6, 23, 45))
    assert(triDecroissant(List(45, 23, 0, 3, 1, 3, 6)) === List(45, 23, 6, 3, 3, 1, 0))
  }

  test("Tri - with order function - chars list") {
    assert(triCroissantChar(List('a', 'z', 'E', '1', 'r')) === List('1', 'E', 'a', 'r', 'z'))
  }
}
