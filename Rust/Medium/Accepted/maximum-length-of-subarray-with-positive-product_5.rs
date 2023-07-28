impl Solution {
    pub fn get_max_len(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut positive = 0;
        let mut negative = 0;
        for i in nums {
            if i == 0 {
                positive = 0;
                negative = 0;
            } else if i > 0 {
                positive += 1;
                if negative > 0 {
                    negative += 1;
                }
            } else {
                let t = positive;
                positive = if negative > 0 { negative + 1 } else { 0 };
                negative = t + 1;
            }
            max = max.max(positive);
        }
        max
    }
}