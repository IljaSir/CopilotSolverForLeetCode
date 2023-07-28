impl Solution {
    pub fn split_num(num: i32) -> i32 {
        
        let mut num1 = 0;
        let mut num2 = 0;
        let mut i = 1;
        let mut k = 0;
        let mut num = num;
        while num > 0 {
            let x = num % 10;
            if x == 0 {
                num1 = num1 * 10 + x;
                num2 = num2 * 10 + x;
                k += 1;
            } else if x == 1 {
                num1 = num1 * 10 + x;
            } else if x == 2 {
                if k > 0 {
                    num2 = num2 * 10 + 1;
                    num1 = num1 * 10 + 1;
                    k -= 1;
                } else {
                    num2 = num2 * 10 + x;
                }
            } else if x == 3 {
                if k > 0 {
                    num2 = num2 * 10 + 1;
                    num1 = num1 * 10 + 2;
                    k -= 1;
                } else {
                    num2 = num2 * 10 + x;
                }
            } else if x == 4 {
                if k > 0 {
                    num2 = num2 * 10 + 2;
                    num1 = num1 * 10 + 2;
                    k -= 1;
                } else {
                    num2 = num2 * 10 + x;
                }
            } else if x == 5 {
                if k > 0 {
                    num2 = num2 * 10 + 2;
                    num1 = num1 * 10 + 3;
                    k -= 1;
                } else {
                    num2 = num2 * 10 + x;
                }
            } else if x == 6 {
                if k > 0 {
                    num2 = num2 * 10 + 3;
                    num1 = num1 * 10 + 3;
                    k -= 1;
                } else {
                    num2 = num2 * 10 + x;
                }
            } else if x == 7 {
                if k > 0 {
                    num2 = num2 * 10 + 3;
                    num1 = num1 * 10 + 4;
                    k -= 1;
                } else {
                    num
    }
}