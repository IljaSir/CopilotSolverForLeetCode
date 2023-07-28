impl Solution {
    pub fn next_greater_element(n: i32) -> i32 {
        

        let mut n = n;
        let mut nums = Vec::new();
        while n > 0 {
            nums.push(n % 10);
            n /= 10;
        }
        let mut i = 0;
        for i in 0..nums.len()-1 {
            if nums[i] > nums[i+1] {
                break;
            }
        }
        if i == nums.len()-1 {
            return -1;
        }
        let mut j = 0;
        for j in 0..=i {
            if nums[j] > nums[i+1] {
                break;
            }
        }
        nums.swap(i+1, j);
        let mut res = 0;
        for i in 0..nums.len() {
            res = res * 10 + nums[nums.len()-i-1];
        }
        if res > std::i32::MAX as i64 {
            return -1;
        }
        res as i32
    }
}