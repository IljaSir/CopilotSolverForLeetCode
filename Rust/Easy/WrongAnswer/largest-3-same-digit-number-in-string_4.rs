impl Solution {
    pub fn largest_good_integer(num: String) -> String {
        
        let mut arr = [0; 10];
        for c in num.chars() {
            arr[c as usize - '0' as usize] += 1;
        }
        let mut res = String::new();
        for i in (0..10).rev() {
            let cnt = arr[i];
            if cnt >= 3 {
                for _ in 0..cnt {
                    res.push((i + '0' as usize) as u8 as char);
                }
                return res;
            }
        }
        res
    }
}