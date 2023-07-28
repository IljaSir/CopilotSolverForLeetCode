impl Solution {
    pub fn reconstruct_queue(people: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut people = people;
        people.sort_by_key(|v| (v[0], -v[1]));
        let mut res = Vec::new();
        for v in people {
            res.insert(v[1] as usize, v);
        }
        res
    }
}