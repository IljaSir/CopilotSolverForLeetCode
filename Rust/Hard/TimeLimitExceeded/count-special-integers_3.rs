impl Solution {
    pub fn count_special_numbers(n: i32) -> i32 {
        
        let mut count = 0;
        for i in 1..=n {
            let mut digits = vec![false; 10];
            let mut j = i;
            while j > 0 {
                let d = j % 10;
                if digits[d as usize] {
                    break;
                }
                digits[d as usize] = true;
                j /= 10;
            }
            if j == 0 {
                count += 1;
            }
        }
        count
    }
}