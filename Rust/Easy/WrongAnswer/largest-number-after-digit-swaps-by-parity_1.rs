impl Solution {
    pub fn largest_integer(num: i32) -> i32 {
        
        let mut num = num;
        let mut nums = Vec::new();
        while num > 0 {
            nums.push(num % 10);
            num /= 10;
        }
        nums.sort_by(|a, b| b.cmp(a));
        let mut res = 0;
        for i in 0..nums.len() {
            res = res * 10 + nums[i];
        }
        res
    }
}