impl Solution {
    pub fn divisibility_array(word: String, m: i32) -> Vec<i32> {
        
        let mut result = vec![0; word.len()];
        let mut remainder = 0;
        for (i, c) in word.chars().enumerate() {
            remainder = (remainder * 10 + c as i32 - '0' as i32) % m;
            if remainder == 0 {
                result[i] = 1;
            }
        }
        result
    }
}