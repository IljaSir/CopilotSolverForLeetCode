impl Solution {
    pub fn max_satisfied(customers: Vec<i32>, grumpy: Vec<i32>, minutes: i32) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut temp = 0;
        let mut i = 0;
        for (i, (c, g)) in customers.iter().zip(grumpy).enumerate() {
            if g == 0 {
                sum += c;
            } else {
                temp += c;
            }
            if i as i32 >= minutes {
                if grumpy[i - minutes as usize] == 1 {
                    temp -= customers[i - minutes as usize];
                }
            }
            max = max.max(temp);
        }
        sum + max
    }
}