impl Solution {
    pub fn minimum_average_difference(nums: Vec<i32>) -> i32 {
        
        let mut acc = Vec::new();
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            acc.push(sum);
        }
        let mut min = std::i32::MAX;
        let mut min_idx = 0;
        for i in 0..nums.len() {
            let mut l = 1;
            let mut r = nums.len() - i;
            while r - l > 1 {
                let m = (l + r) / 2;
                let a = acc[i + m - 1] - acc[i] + nums[i];
                let b = acc[nums.len() - 1] - acc[i + m - 1];
                if a * m as i32 > b * (i + 1) as i32 {
                    l = m;
                } else {
                    r = m;
                }
            }
            let a = acc[i + l - 1] - acc[i] + nums[i];
            let b = acc[nums.len() - 1] - acc[i + l - 1];
            if a * l as i32 - b * (i + 1) as i32 < min {
                min = a * l as i32 - b * (i + 1) as i32;
                min_idx = i as i32;
            }
            let a = acc[i + r - 1] - acc[i] + nums[i];
            let b = acc[nums.len() - 1] - acc[i + r - 1];
            if a * r as i32 - b * (i + 1) as i32 < min {
                min = a * r as i32 - b * (i + 1) as i32;
                min_idx = i as i32;
            }
        }
        min_idx
    }
}