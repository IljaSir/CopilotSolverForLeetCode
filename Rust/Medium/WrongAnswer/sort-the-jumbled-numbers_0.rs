impl Solution {
    pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort_by(|a, b| {
            let mut a = *a;
            let mut b = *b;
            let mut a_mapped = 0;
            let mut b_mapped = 0;
            loop {
                if a == 0 && b == 0 {
                    break;
                }
                let a_digit = a % 10;
                let b_digit = b % 10;
                a_mapped = a_mapped * 10 + mapping[a_digit as usize];
                b_mapped = b_mapped * 10 + mapping[b_digit as usize];
                a /= 10;
                b /= 10;
            }
            a_mapped.cmp(&b_mapped)
        });
        nums
    }
}