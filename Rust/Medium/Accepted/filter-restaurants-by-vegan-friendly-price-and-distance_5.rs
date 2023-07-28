impl Solution {
    pub fn filter_restaurants(restaurants: Vec<Vec<i32>>, vegan_friendly: i32, max_price: i32, max_distance: i32) -> Vec<i32> {
        
        let mut res = restaurants.iter().filter(|x| {
            if vegan_friendly == 1 {
                x[2] == 1 && x[3] <= max_price && x[4] <= max_distance
            } else {
                x[3] <= max_price && x[4] <= max_distance
            }
        }).map(|x| x[0]).collect::<Vec<i32>>();
        res.sort_by(|a, b| {
            let mut r = restaurants.iter().find(|x| x[0] == *b).unwrap()[1].cmp(&restaurants.iter().find(|x| x[0] == *a).unwrap()[1]);
            if r == std::cmp::Ordering::Equal {
                r = b.cmp(a);
            }
            r
        });
        res
    }
}