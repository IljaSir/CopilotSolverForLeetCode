impl Solution {
    pub fn largest_integer(num: i32) -> i32 {
        
        let mut even = vec![];
        let mut odd = vec![];
        let mut n = num;
        while n > 0 {
            let r = n % 10;
            n = n / 10;
            if r % 2 == 0 {
                even.push(r);
            } else {
                odd.push(r);
            }
        }
        even.sort();
        odd.sort();
        let mut result = 0;
        while even.len() > 0 || odd.len() > 0 {
            if even.len() > 0 {
                let v = even.pop().unwrap();
                result = result * 10 + v;
            }
            if odd.len() > 0 {
                let v = odd.pop().unwrap();
                result = result * 10 + v;
            }
        }
        result
    }
}