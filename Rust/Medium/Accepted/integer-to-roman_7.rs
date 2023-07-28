impl Solution {
    pub fn int_to_roman(num: i32) -> String {
        

        let mut n = num;
        let mut res = String::new();
        let mut i = 0;
        let roman = vec![
            vec!['I', 'V'],
            vec!['X', 'L'],
            vec!['C', 'D'],
            vec!['M', ' '],
        ];
        while n > 0 {
            let m = n % 10;
            n /= 10;
            if m == 0 {
                i += 1;
                continue;
            }
            let mut s = String::new();
            if m == 9 {
                s.push(roman[i][0]);
                s.push(roman[i + 1][0]);
            } else if m == 4 {
                s.push(roman[i][0]);
                s.push(roman[i][1]);
            } else if m >= 5 {
                s.push(roman[i][1]);
                for _ in 0..m - 5 {
                    s.push(roman[i][0]);
                }
            } else {
                for _ in 0..m {
                    s.push(roman[i][0]);
                }
            }
            res = s + &res;
            i += 1;
        }
        res
    }
}