impl Solution {
    pub fn can_three_parts_equal_sum(arr: Vec<i32>) -> bool {
        
        let sum = arr.iter().sum::<i32>();
        if sum % 3 != 0 {
            return false;
        }
        let part = sum / 3;
        let mut count = 0;
        let mut cur = 0;
        for i in 0..arr.len() {
            cur += arr[i];
            if cur == part {
                count += 1;
                cur = 0;
            }
        }
        count >= 3
    }
}