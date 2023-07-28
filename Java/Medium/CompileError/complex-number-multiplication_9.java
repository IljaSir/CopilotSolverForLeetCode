class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        
        ComplexNumber c1 = new ComplexNumber(num1);
        ComplexNumber c2 = new ComplexNumber(num2);
        ComplexNumber c3 = c1.multiply(c2);
        return c3.toString();
    }
}
    }
}