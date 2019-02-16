package complexnumbers;

public class Complex {
    
    //two attributes for the complex number
    private int real, imaginary ;
    
    //empty constructor
    public Complex(){}
    
    //constructor for the two attributes
    public Complex(int real, int imaginary){
        this.real = real ;
        this.imaginary = imaginary ;
    }
    
    //real number setter method
    public void setReal(int real){
        this.real = real ;
    }
    
    //real number getter method
    public int getReal(){
        return this.real ;
    }
    
    //imaginary number setter method
    public void setImaginary(int imaginary){
        this.imaginary = imaginary ;
    }
    
    //imaginary number getter method
    public int getImaginary(){
        return this.imaginary ;
    }
    
    //a method to set real and imaginary numbers from a string
    //if the string in right format return true else return false
    public boolean setNumberFromString(String num){
        
        //split the string to array of strings(real and imaginary)
        String[] numArray = num.split("(?=[+-])");
        
        switch (numArray.length) {
            //if array length equal to two then both imaginary and real exists
            case 2:
                //if first array element contains i, then it's the imaginary number
                if(numArray[0].contains("i")){
                    try{
                        this.real = Integer.parseInt(numArray[1]) ;     //set real
                        this.imaginary = Integer.parseInt(numArray[0].replace("i", "")) ;   //remove i and set imaginary
                    }catch(NumberFormatException e){
                        //catch NumberFormatException to detect if the string was not in the proper format
                        return false ;
                    }
                }else{
                    try{
                        this.real = Integer.parseInt(numArray[0]) ;     //set real
                        this.imaginary = Integer.parseInt(numArray[1].replace("i", "")) ;   //remove i and set imaginary
                    }catch(NumberFormatException e){
                        //catch NumberFormatException to detect if the string was not in the proper format
                        return false ;
                    }
                }   break;
            //if array length equal to one then either imaginary or real exists
            case 1:
                if(numArray[0].contains("i")){
                    try{
                        this.real = 0 ;     //set real to 0
                        this.imaginary = Integer.parseInt(numArray[0].replace("i", "")) ;   //remove i and set imaginary
                    }catch(NumberFormatException e){
                        //catch NumberFormatException to detect if the string was not in the proper format
                        return false ;
                    }
                }else{
                    try{
                        this.real = Integer.parseInt(numArray[0]) ;     //set real
                        this.imaginary = 0 ;        //set imaginary to 0
                    }catch(NumberFormatException e){
                        //catch NumberFormatException to detect if the string was not in the proper format
                        return false ;
                    }
                }   break;
            default:
                //if array length is neither 1 nor 2, then string was not in the proper format
                return false ;
        }
        
        //if convert is successful return true
        return true ;
    }
    
    //a method to add another complex number to this one
    public Complex addition(Complex num2){
        int realResult = this.real + num2.getReal() ;
        int imgResult = this.imaginary + num2.getImaginary() ;
        Complex result = new Complex(realResult, imgResult) ; 
        return result ;
    }
    
    //a method to sub another complex number from this one
    public Complex subtraction(Complex num2){
        int realResult = this.real - num2.getReal() ;
        int imgResult = this.imaginary - num2.getImaginary() ;
        Complex result = new Complex(realResult, imgResult) ; 
        return result ;
    }
    
    //a method to multiply another complex number with this one
    public Complex multiply(Complex num2){
        Complex temp1 = new Complex(this.real*num2.getReal(),
                                        this.imaginary*num2.getReal()) ;
        Complex temp2 = new Complex(-this.imaginary*num2.getImaginary(),
                                        this.real*num2.getImaginary()) ;
        return temp1.addition(temp2) ;
    }
    
    //a method that prints number in proper format
    public void printNumber(){
        if (this.imaginary >= 0){
        //if imaginary part is a positive number, add '+' sign
            String s = String.valueOf(this.real) + "+" + String.valueOf(this.imaginary) + "i" ;
            System.out.println(s);
        }else{
            String s =  String.valueOf(this.real) + String.valueOf(this.imaginary) + "i" ;
            System.out.println(s) ;
        }
    }
    
}
