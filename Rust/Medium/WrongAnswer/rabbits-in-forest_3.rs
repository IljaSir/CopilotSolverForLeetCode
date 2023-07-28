impl Solution {
    pub fn num_rabbits(answers: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for &i in answers.iter() {
            if i == 0 {
                count += 1;
                continue;
            }
            if let Some(&v) = map.get(&i) {
                if v == 1 {
                    map.remove(&i);
                    count += i + 1;
                } else {
                    map.insert(i, v - 1);
                }
            } else {
                map.insert(i, i);
                count += i + 1;
            }
        }
        count
    }
}