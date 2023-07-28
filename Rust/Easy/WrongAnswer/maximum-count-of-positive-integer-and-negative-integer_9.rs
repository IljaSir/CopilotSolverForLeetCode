impl Solution {
    pub fn maximum_count(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut prev = 0;
        for i in nums {
            if i >= 0 {
                if prev < 0 {
                    max = max.max(count);
                    count = 0;
                }
                count += 1;
            } else {
                if prev >= 0 {
                    max = max.max(count);
                    count = 0;
                }
                count += 1;
            }
            prev = i;
        }
        max.max(count)
    }
}