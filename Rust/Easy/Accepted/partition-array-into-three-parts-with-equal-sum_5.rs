impl Solution {
    pub fn can_three_parts_equal_sum(arr: Vec<i32>) -> bool {
        
        let sum = arr.iter().sum::<i32>();
        if sum % 3 != 0 {
            return false;
        }
        let target = sum / 3;
        let mut count = 0;
        let mut sub_sum = 0;
        for i in 0..arr.len() {
            sub_sum += arr[i];
            if sub_sum == target {
                count += 1;
                sub_sum = 0;
            }
        }
        count >= 3
    }
}