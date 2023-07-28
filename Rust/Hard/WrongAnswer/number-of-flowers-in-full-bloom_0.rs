impl Solution {
    pub fn full_bloom_flowers(flowers: Vec<Vec<i32>>, people: Vec<i32>) -> Vec<i32> {
        
        let mut flowers = flowers;
        flowers.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut people = people;
        people.sort();
        let mut res = vec![0; people.len()];
        let mut i = 0;
        for j in 0..people.len() {
            while i < flowers.len() && flowers[i][0] <= people[j] {
                for k in 0..res.len() {
                    if people[k] >= flowers[i][0] && people[k] <= flowers[i][1] {
                        res[k] += 1;
                    }
                }
                i += 1;
            }
        }
        res
    }
}