#!/bin/ruby

require 'json'
require 'stringio'

# Complete the maximumToys function below.
def maximumToys(prices, k)
    sortedPrices = prices.sort
    sum = 0
    count = 0
    sortedPrices.each do |p|
        if (sum + p) >= k 
            break
        else
            sum += p
            count += 1
        end
    end
    count
end

fptr = File.open(ENV['OUTPUT_PATH'], 'w')

nk = gets.rstrip.split

n = nk[0].to_i

k = nk[1].to_i

prices = gets.rstrip.split(' ').map(&:to_i)

result = maximumToys prices, k

fptr.write result
fptr.write "\n"

fptr.close()
