impl Solution {
    pub fn minimum_numbers(num: i32, k: i32) -> i32 {
        
        let mut s = 0;
        let mut count = 0;
        while s < num {
            s += k;
            count += 1;
        }
        if s == num {
            count
        } else {
            -1
        }
    }
}