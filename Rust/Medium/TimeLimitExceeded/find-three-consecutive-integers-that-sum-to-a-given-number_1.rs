impl Solution {
    pub fn sum_of_three(num: i64) -> Vec<i64> {
        
        let mut result = Vec::new();
        for i in 1..=num {
            let sum = i + (i + 1) + (i + 2);
            if sum == num {
                result.push(i);
                result.push(i + 1);
                result.push(i + 2);
                break;
            }
        }
        result
    }
}