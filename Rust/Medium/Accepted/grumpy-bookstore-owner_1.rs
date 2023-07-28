impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        
        let mut satisfied = 0;
        let mut max = 0;
        let mut temp = 0;
        for i in 0..customers.len() {
            if grumpy[i] == 0 {
                satisfied += customers[i];
            } else {
                temp += customers[i];
            }
            if i >= minutes as usize {
                temp -= customers[i - minutes as usize] * grumpy[i - minutes as usize];
            }
            max = max.max(temp);
        }
        satisfied + max
    }
}