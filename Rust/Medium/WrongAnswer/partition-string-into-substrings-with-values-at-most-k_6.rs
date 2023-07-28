impl Solution {
    pub fn minimum_partition(s: String, k: i32) -> i32 {
        
        let mut result = 0;
        let mut max = 0;
        let mut last = 0;
        for c in s.chars() {
            let i = c as i32 - '0' as i32;
            max = max.max(i);
            if max * (result - last + 1) > k {
                result += 1;
                last = result;
                max = i;
            }
        }
        result + 1
    }
}