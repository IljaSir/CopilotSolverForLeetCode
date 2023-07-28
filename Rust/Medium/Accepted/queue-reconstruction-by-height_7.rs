impl Solution {
    pub fn reconstruct_queue(people: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut people = people;
        people.sort_by_key(|v| (v[0], -v[1]));
        let mut res: Vec<Vec<i32>> = Vec::new();
        for p in people.into_iter().rev() {
            res.insert(p[1] as usize, p);
        }
        res
    }
}