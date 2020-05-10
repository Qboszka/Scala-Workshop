package Exceptions

class InvalidAgeException(s:String) extends Exception(s){}

class ExceptionExample{
  @throws(classOf[InvalidAgeException])
  def validate(age:Int){
    if(age<18){
      throw new InvalidAgeException("Not eligible")
    }else{
      println("You are eligible")
    }
  }
}
