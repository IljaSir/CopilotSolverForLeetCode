impl Solution {
    pub fn int_to_roman(num: i32) -> String {
        

        let mut num = num;
        let mut res = Vec::new();
        while num > 0 {
            if num >= 1000 {
                res.push('M');
                num -= 1000;
            } else if num >= 900 {
                res.push('C');
                res.push('M');
                num -= 900;
            } else if num >= 500 {
                res.push('D');
                num -= 500;
            } else if num >= 400 {
                res.push('C');
                res.push('D');
                num -= 400;
            } else if num >= 100 {
                res.push('C');
                num -= 100;
            } else if num >= 90 {
                res.push('X');
                res.push('C');
                num -= 90;
            } else if num >= 50 {
                res.push('L');
                num -= 50;
            } else if num >= 40 {
                res.push('X');
                res.push('L');
                num -= 40;
            } else if num >= 10 {
                res.push('X');
                num -= 10;
            } else if num >= 9 {
                res.push('I');
                res.push('X');
                num -= 9;
            } else if num >= 5 {
                res.push('V');
                num -= 5;
            } else if num >= 4 {
                res.push('I');
                res.push('V');
                num -= 4;
            } else {
                res.push('I');
                num -= 1;
            }
        }
        res.into_iter().collect()
    }
}