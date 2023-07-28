impl Solution {
    pub fn reconstruct_queue(people: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut people = people;
        people.sort_by_key(|p| (-(p[0] as i64), p[1] as i64));
        let mut res = Vec::with_capacity(people.len());
        for p in people {
            res.insert(p[1] as usize, p);
        }
        res
    }
}