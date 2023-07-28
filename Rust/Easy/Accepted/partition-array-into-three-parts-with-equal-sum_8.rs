impl Solution {
    pub fn can_three_parts_equal_sum(arr: Vec<i32>) -> bool {
        
        let sum = arr.iter().sum::<i32>();
        if sum % 3 != 0 { return false; }
        let mut count = 0;
        let mut total = 0;
        for i in 0..arr.len() {
            total += arr[i];
            if total == sum / 3 {
                count += 1;
                total = 0;
            }
        }
        count >= 3
    }
}