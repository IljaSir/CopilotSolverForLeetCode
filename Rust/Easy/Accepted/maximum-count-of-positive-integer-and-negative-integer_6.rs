impl Solution {
    pub fn maximum_count(nums: Vec<i32>) -> i32 {
        
        let mut pos = 0;
        let mut neg = 0;
        let mut max = 0;
        for i in 0..nums.len() {
            if nums[i] < 0 {
                if pos > 0 {
                    max = std::cmp::max(max, pos);
                    pos = 0;
                }
                neg += 1;
            } else if nums[i] > 0 {
                if neg > 0 {
                    max = std::cmp::max(max, neg);
                    neg = 0;
                }
                pos += 1;
            } else {
                max = std::cmp::max(max, neg);
                max = std::cmp::max(max, pos);
                neg = 0;
                pos = 0;
            }
        }
        if pos > 0 {
            max = std::cmp::max(max, pos);
        }
        if neg > 0 {
            max = std::cmp::max(max, neg);
        }
        max
    }
}