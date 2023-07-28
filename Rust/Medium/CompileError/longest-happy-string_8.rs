impl Solution {
    pub fn longest_diverse_string(a: i32, b: i32, c: i32) -> String {
        
        let mut count = vec![a, b, c];
        let mut res = String::new();
        let mut prev = -1;
        while count.iter().any(|&x| x > 0) {
            let mut max = 0;
            let mut index = 0;
            for i in 0..3 {
                if count[i] > max && i != prev {
                    max = count[i];
                    index = i;
                }
            }
            if max == 0 {
                break;
            }
            if max >= 2 {
                res.push(('a' as u8 + index as u8) as char);
                res.push(('a' as u8 + index as u8) as char);
                count[index] -= 2;
            } else {
                res.push(('a' as u8 + index as u8) as char);
                count[index] -= 1;
            }
            prev = index;
        }
        res
    }
}