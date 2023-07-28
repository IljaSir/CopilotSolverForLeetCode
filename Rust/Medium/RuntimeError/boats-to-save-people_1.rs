impl Solution {
    pub fn num_rescue_boats(people: Vec<i32>, limit: i32) -> i32 {
        
        let mut people = people;
        people.sort();
        let mut i = 0;
        let mut j = people.len() - 1;
        let mut boats = 0;
        while i <= j {
            boats += 1;
            if people[i] + people[j] <= limit {
                i += 1;
            }
            j -= 1;
        }
        boats
    }
}