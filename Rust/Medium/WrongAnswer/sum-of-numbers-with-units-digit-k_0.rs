impl Solution {
    pub fn minimum_numbers(num: i32, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut count = 0;
        while sum < num {
            sum += k;
            count += 1;
        }
        if sum == num {
            count
        } else {
            -1
        }
    }
}