impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> Vec<i32> {
        

        let mut count1 = 0;
        let mut count2 = 0;
        let mut candidate1 = 0;
        let mut candidate2 = 0;
        for i in 0..nums.len() {
            if candidate1 == nums[i] {
                count1 += 1;
            } else if candidate2 == nums[i] {
                count2 += 1;
            } else if count1 == 0 {
                candidate1 = nums[i];
                count1 += 1;
            } else if count2 == 0 {
                candidate2 = nums[i];
                count2 += 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        let mut result = Vec::new();
        if count1 > 0 {
            let mut c = 0;
            for i in 0..nums.len() {
                if nums[i] == candidate1 {
                    c += 1;
                }
            }
            if c > nums.len() / 3 {
                result.push(candidate1);
            }
        }
        if count2 > 0 {
            let mut c = 0;
            for i in 0..nums.len() {
                if nums[i] == candidate2 {
                    c += 1;
                }
            }
            if c > nums.len() / 3 {
                result.push(candidate2);
            }
        }
        result
    }
}