impl Solution {
    pub fn reconstruct_queue(people: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        

        let mut people = people;
        people.sort_by(|v1, v2| {
            if v1[0] == v2[0] {
                v1[1].cmp(&v2[1])
            } else {
                v2[0].cmp(&v1[0])
            }
        });
        let mut result = Vec::new();
        for p in people {
            result.insert(p[1] as usize, p);
        }
        result
    }
}