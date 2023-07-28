impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        
        let mut max = 0;
        let mut sum = 0;
        let mut i = 0;
        let mut j = 0;
        let mut m = minutes as usize;
        let mut n = customers.len();
        while j < n {
            if grumpy[j] == 0 {
                sum += customers[j];
            }
            if j - i + 1 > m {
                if grumpy[i] == 1 {
                    sum -= customers[i];
                }
                i += 1;
            }
            max = max.max(sum);
            j += 1;
        }
        max
    }
}