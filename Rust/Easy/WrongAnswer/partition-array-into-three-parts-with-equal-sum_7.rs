impl Solution {
    pub fn can_three_parts_equal_sum(arr: Vec<i32>) -> bool {
        
        let sum = arr.iter().sum::<i32>();
        if sum % 3 != 0 {
            return false;
        }
        let mut sum = sum / 3;
        let mut cnt = 0;
        for i in 0..arr.len() {
            sum -= arr[i];
            if sum == 0 {
                sum = sum / 3;
                cnt += 1;
                if cnt == 3 {
                    return true;
                }
            }
        }
        false
    }
}