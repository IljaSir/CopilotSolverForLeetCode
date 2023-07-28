impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> Vec<i32> {
        

        let mut result: Vec<i32> = Vec::new();
        let mut count1 = 0;
        let mut count2 = 0;
        let mut candidate1 = 0;
        let mut candidate2 = 0;
        for n in nums {
            if n == candidate1 {
                count1 += 1;
            } else if n == candidate2 {
                count2 += 1;
            } else if count1 == 0 {
                candidate1 = n;
                count1 = 1;
            } else if count2 == 0 {
                candidate2 = n;
                count2 = 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        count1 = 0;
        count2 = 0;
        for n in &nums {
            if *n == candidate1 {
                count1 += 1;
            } else if *n == candidate2 {
                count2 += 1;
            }
        }
        if count1 > nums.len() / 3 {
            result.push(candidate1);
        }
        if count2 > nums.len() / 3 {
            result.push(candidate2);
        }
        result
    }
}