impl Solution {
    pub fn intersection(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        let mut first = nums[0].clone();
        for i in 1..nums.len() {
            let mut second = nums[i].clone();
            let mut temp: Vec<i32> = Vec::new();
            for j in 0..first.len() {
                let mut flag = false;
                for k in 0..second.len() {
                    if first[j] == second[k] {
                        flag = true;
                        break;
                    }
                }
                if flag {
                    temp.push(first[j]);
                }
            }
            first = temp.clone();
        }
        result = first.clone();
        result.sort();
        result
    }
}