impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> Vec<i32> {
        

        let mut count1 = 0;
        let mut count2 = 0;
        let mut candidate1 = 0;
        let mut candidate2 = 1;
        for i in nums {
            if candidate1 == i {
                count1 += 1;
            } else if candidate2 == i {
                count2 += 1;
            } else if count1 == 0 {
                candidate1 = i;
                count1 = 1;
            } else if count2 == 0 {
                candidate2 = i;
                count2 = 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        let mut result = vec![];
        let mut count = 0;
        for i in &nums {
            if *i == candidate1 {
                count += 1;
            }
        }
        if count > nums.len() / 3 {
            result.push(candidate1);
        }
        count = 0;
        for i in &nums {
            if *i == candidate2 {
                count += 1;
            }
        }
        if count > nums.len() / 3 {
            result.push(candidate2);
        }
        result
    }
}